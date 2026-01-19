# Blunt Sabre - A Large Language Model based narrative planner

This project uses [Sabre](https://github.com/sgware/sabre) and transforms it into a LLM based planner.
Most of the project re-uses the sabre code to convert story-domains from Sabre language into Java objects.

This project aims to use reasoning capabilities of the LLM instead of using algorithmic methods used in Sabre planner to
reason about actions according to consenting characters in a story domain.

This planner uses classical planning capabilities of the Sabre planner and uses LLMs (Right now it uses ChatGPT 5 models)
to do narrative planning.