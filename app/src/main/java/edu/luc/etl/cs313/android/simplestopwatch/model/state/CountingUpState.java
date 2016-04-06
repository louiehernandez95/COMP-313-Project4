package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class CountingUpState implements StopwatchState {

    public CountingUpState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    private int tickCount = 0;

    @Override
    public void onClick() {
        if (sm.getTime() == 99) {
            sm.toCountingDownState();
            //sm.beep();
        } else {
            tickCount = 0;
            sm.actionInc();
        }
    }

    @Override
    public void onTick() {
        if (tickCount == 3) {
            sm.toCountingDownState();
            //sm.beep();
        } else {
            tickCount++;
        }
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.COUNTING_UP;
    }
}