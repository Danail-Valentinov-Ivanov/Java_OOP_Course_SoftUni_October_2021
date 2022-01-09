package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {
    private static final String COMMANDS_PATH_NAME = "barracksWars.core.commands.";
    private static final String EXECUTE_METHOD_NAME = "execute";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) {
//		without reflection
//		String result;
//		switch (commandName) {
//			case "add":
//				Add addCommand = new Add(data, repository, unitFactory);
//				result = addCommand.execute();
//				break;
//			case "report":
//				Report reportCommand = new Report(data, repository, unitFactory);
//				result = reportCommand.execute();
//				break;
//			case "fight":
//				Fight fightCommand = new Fight(data, repository, unitFactory);
//				result = fightCommand.execute();
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;

//		with reflection
        String className = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        String result = null;
        try {
            Class clazz = Class.forName(COMMANDS_PATH_NAME + className);
            Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class, Repository.class
                    , UnitFactory.class);
            Command commandInstance = constructor.newInstance(data, repository, unitFactory);
            Method methodExecute = clazz.getDeclaredMethod(EXECUTE_METHOD_NAME);
            try {
                result = (String) methodExecute.invoke(commandInstance);
            } catch (InvocationTargetException exception){
               return exception.getCause().getMessage();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | InstantiationException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return result;
    }
}
