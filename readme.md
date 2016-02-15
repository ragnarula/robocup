# Intelligently Artificial F.C. - A Robocup Simulation League Team

> RoboCup is an annual international robotics competition proposed[1] and founded in 1997. The aim is to promote robotics and AI research, by offering a publicly appealing, but formidable challenge. The name RoboCup is a contraction of the competition's full name, "Robot Soccer World Cup", but there are many other stages of the competition such as "RoboCupRescue", "RoboCup@Home" and "RoboCupJunior". In 2015 the world's competition was held in Hefei, China. RoboCup 2016 will be held in Leipzig, Germany.[2]
> See [Wikipedia](https://en.wikipedia.org/wiki/RoboCup)

This Robocup simulation team is designed around the concept of a one-way data flow. Our model is re-created at every simulation step. The process begins with the server sending our ```ControllerPlayer``` information via the ```info*``` methods. Once all the information is gathered into a Percept, a new model object is created. This model object is passed sequentially through a chain of "AI Components" (in package ```ai```) that implement the ```IChainable``` Interface via the ```ai.AbstractSimpleAIComponent``` abstract class.

Each component is responsible for adding more information in to the model by using information contained in the percept. This could be simple information such as the current play mode, or involve more complex calculations such as to determine the agent's current location.

By the time the model has passed through all the components the model should contain enough information to determine what set of actions need to be executed. Actions are executed in the final component, the ```AgentActionAIComponent```. Here the state design pattern is used to organise the agent's behaviour.

The concept is illustrated in the diagram below

![AI Model Diagram](/docs/doc-files/arch_functional.jpg)