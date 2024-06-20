package dev.khaliuk.ccshell.handler;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

public class HandlerFactory {
    private static final Handler DEFAULT_HANDLER = new DefaultHandler();

    private final Map<Command, Handler> commandHandlers = new EnumMap<>(Command.class);

    public HandlerFactory() throws NoSuchMethodException, InvocationTargetException,
        InstantiationException, IllegalAccessException {
        initHandlers();
    }

    public Handler getHandler(String[] arguments) {
        Command command;

        try {
            command = Command.valueOf(arguments[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            return DEFAULT_HANDLER;
        }

        return commandHandlers.get(command);
    }

    private void initHandlers() throws NoSuchMethodException, InstantiationException,
        IllegalAccessException, InvocationTargetException {
        for (Command command : Command.values()) {
            Constructor<? extends Handler> handlerConstructor = command.handler.getConstructor();
            Handler handler = handlerConstructor.newInstance();
            commandHandlers.put(command, handler);
        }
    }

    enum Command {
        ECHO(Echo.class),
        EXIT(Exit.class),
        TYPE(Type.class),
        ;

        private final Class<? extends Handler> handler;

        Command(Class<? extends Handler> handler) {
            this.handler = handler;
        }

        static boolean contains(String commandName) {
            for (Command command : values()) {
                if (command.name().equals(commandName)) {
                    return true;
                }
            }
            return false;
        }
    }
}
