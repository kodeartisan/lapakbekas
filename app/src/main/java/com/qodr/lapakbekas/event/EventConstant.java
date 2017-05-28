package com.qodr.lapakbekas.event;

/**
 * Created by kodeartisan on 27/05/17.
 */

public final class EventConstant {

    public final static int REFRESH = 0;
    public final static int LOADMORE = 1;
    public final static int DELETE = 2;
    public final static int ADD = 4;

    private EventConstant() throws InstantiationException {
        throw new InstantiationException("This utility is not created for instatiation");
    }

}
