package com.idevicesinc.sweetblue;

/**
 * 
 * 
 *
 */
abstract class PA_Task_RequiresBleOn extends PA_Task
{
	public PA_Task_RequiresBleOn(BleDevice device, double timeout, I_StateListener listener)
	{
		super(device, timeout, listener);
	}
	
	public PA_Task_RequiresBleOn(BleManager manager, I_StateListener listener)
	{
		super(manager, listener);
	}

	public PA_Task_RequiresBleOn(BleManager manager, I_StateListener listener, double timeout)
	{
		super(manager, listener, timeout);
	}

	@Override protected boolean isExecutable()
	{
		return super.isExecutable() && BleState.ON.overlaps(getManager().getNativeStateMask());
	}
	
	@Override public boolean isCancellableBy(PA_Task task)
	{
		if( task instanceof P_Task_TurnBleOff )
		{
			return true;
		}
		
		return super.isCancellableBy(task);
	}
}
