## Difference Between `Class.forName` and `ClassLoader.loadClass`

### `Class.forName`:
* static method of the _Class_ class
* full signature `Class.forName(String name, boolean initialize, ClassLoader loader)`
* By default the classes are initialized at the time of loading. It means that static variables in the classes are initialized.

### `ClassLoader.forName`:
* method of `ClassLoader` instance
* initializes the class lazily (on first use)

