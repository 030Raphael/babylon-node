package com.radixdlt.consensus;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongConsumer;

/**
 * Overly simplistic pacemaker
 */
public final class DumbPacemaker implements Pacemaker, PacemakerRx {
	private final static int TIMEOUT_MILLISECONDS = 500;
	private final List<LongConsumer> timeoutCallbacks = new CopyOnWriteArrayList<>();
	private final AtomicReference<ScheduledFuture<?>> futureDeadlineRef;
	private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	private final AtomicLong currentRound = new AtomicLong();

	public DumbPacemaker() {
		this.futureDeadlineRef = new AtomicReference<>();
	}

	private void scheduleTimeout() {
		long currentRound = getCurrentRound();
		ScheduledFuture<?> future = executorService.schedule(() -> {
			timeoutCallbacks.forEach(callback -> callback.accept(currentRound));
		}, TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS);
		this.futureDeadlineRef.set(future);
	}

	@Override
	public long getCurrentRound() {
		return currentRound.get();
	}

	@Override
	public boolean processLocalTimeout(long round) {
		// we only care if the current round was the one that timed out
		if (currentRound.get() != round) {
			return false;
		}

		// schedule next timeout
		scheduleTimeout();

		return true;
	}

	@Override
	public void processQC(long round) {
		if (round < currentRound.get()) {
			return;
		}

		// FIXME: For sure there are race conditions here
		currentRound.getAndIncrement();

		ScheduledFuture<?> future = this.futureDeadlineRef.get();
		future.cancel(false);
		scheduleTimeout();
	}

	@Override
	public void start() {
		scheduleTimeout();
	}

	@Override
	public void addTimeoutCallback(LongConsumer callback) {
		Objects.requireNonNull(callback, "callback");
		this.timeoutCallbacks.add(callback);
	}
}
