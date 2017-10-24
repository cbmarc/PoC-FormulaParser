# PoC-FormulaParser
Given a string with operators and keywords, parse and act according to formulas that match the give keywords.

The idea is to show in a clear architecture, an easily expandable way of creating a meta language to process a given input string.
For example, let's assume our app needs to generate a string like this:

```
HelloWorld9544545CoolSuffix
```

and the middle number must be a random. We could change the input to:

```
HelloWorld + random + CoolSuffix
```

and by defining a formula that handles de 'random' keyword, it would give the expected output.
