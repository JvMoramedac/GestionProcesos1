# Proyecto ContadorPalabras - Ordenador de Números

## Descripción del Proyecto

Este proyecto Java lee números desde la entrada estándar (stdin), los ordena de menor a mayor y los imprime en la salida estándar (stdout). Está diseñado para trabajar con tuberías (pipes) en sistemas Unix/Linux, permitiendo encadenar comandos.

## Estructura del Código

### Clase Principal: `ContadorPalabras.java`

```java
public class ContadorPalabras {
    public static void main(String[] args) {
        // Lectura desde entrada estándar
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        // Procesamiento línea por línea
        while ((Linea = br.readLine()) != null) {
            String[] Dato = Linea.split(" ");
            numeros = new int[Dato.length];
            
            // Conversión y ordenación
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = Integer.parseInt(Dato[i]);
            }
            Arrays.sort(numeros);
            
            // Salida ordenada
            for (int i = 0; i < numeros.length; i++) {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}
```

### Funcionamiento

1. **Lectura**: Utiliza `BufferedReader` e `InputStreamReader` para leer desde `System.in`
2. **Parseo**: Divide cada línea por espacios usando `split(" ")`
3. **Conversión**: Transforma los strings en enteros con `Integer.parseInt()`
4. **Ordenación**: Usa `Arrays.sort()` para ordenar los números
5. **Salida**: Imprime los números ordenados separados por espacios

## Configuración Maven (pom.xml)

### Propiedades Clave

```xml
<properties>
    <maven.compiler.source>25</maven.compiler.source>
    <maven.compiler.target>25</maven.compiler.target>
</properties>
```

### Plugin JAR

```xml
<build>
    <finalName>ContadorPalabras</finalName>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.4.1</version>
            <configuration>
                <archive>
                    <manifest>
                        <addClasspath>true</addClasspath>
                        <mainClass>contadorpalabras.ContadorPalabras</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

**Elementos importantes:**
- `<finalName>`: Define el nombre del JAR resultante
- `<mainClass>`: Especifica la clase principal ejecutable
- `<addClasspath>`: Añade el classpath al manifest

## Compilación y Generación del JAR

### Requisitos Previos
- JDK 25 (o la versión especificada en el pom.xml)
- Maven instalado

### Comandos de Compilación

```bash
# Limpiar compilaciones anteriores
mvn clean

# Compilar el proyecto
mvn compile

# Generar el JAR ejecutable
mvn package

# O todo en un solo comando
mvn clean package
```

El JAR se generará en: `target/ContadorPalabras.jar`

## Uso con Tuberías (Pipes)

### Ejemplo 1: Generar números aleatorios y ordenarlos

```bash
java -jar aleatorio.jar | java -jar ContadorPalabras.jar
```

**Explicación:**
- `aleatorio.jar` genera números aleatorios y los envía a stdout
- El operador `|` (pipe) redirige esa salida como entrada (stdin) de `ContadorPalabras.jar`
- `ContadorPalabras.jar` lee, ordena y muestra los números

### Ejemplo 2: Usando el comando ordenarNumero

```bash
java -jar ordenarNumero.jar | java -jar ContadorPalabras.jar
```

### Ejemplo 3: Entrada manual

```bash
echo "23 5 67 12 89 3" | java -jar ContadorPalabras.jar
```

**Salida esperada:**
```
3 5 12 23 67 89
```

### Ejemplo 4: Desde un archivo

```bash
cat numeros.txt | java -jar ContadorPalabras.jar
```

### Ejemplo 5: Múltiples líneas

```bash
echo -e "5 2 8\n1 9 3\n7 4 6" | java -jar ContadorPalabras.jar
```

**Salida esperada:**
```
2 5 8
1 3 9
4 6 7
```

## Análisis de la Salida del Comando

Según el ejemplo de ejecución:

```
C:\Users\Usuario1\Desktop\Ejemplos_T2\Ejemplos_T2\ordenarNumero\target>
java -jar aleatorio.jar | java -jar ordenarNumero.jar

0 0 2 3 3 13 16 17 22 22 23 25 29 30 32 33 41 41 47 49 54 54 55 56 56 58 58 63 66 68 68 69 71 71 73 74 83 84 86 87 87 88 91 94 94 95 96 98 98 99
```

Esto demuestra:
- La generación de números aleatorios funciona correctamente
- La tubería redirige la salida exitosamente
- Los números se ordenan de menor a mayor
- Se procesan múltiples números en una sola línea

## Manejo de Errores

El código incluye manejo de excepciones:

```java
try {
    // Código de procesamiento
} catch (IOException e) {
    System.out.println(e.getMessage());
} finally {
    // Cierre de recursos
    br.close();
    isr.close();
}
```

## Ventajas del Diseño

1. **Modularidad**: Funciona como filtro en pipelines Unix
2. **Reutilizable**: Se puede combinar con otros programas
3. **Eficiente**: Procesa línea por línea sin cargar todo en memoria
4. **Portable**: JAR ejecutable en cualquier sistema con JVM

## Estructura del Proyecto

```
ContadorPalabras/
│
├── src/
│   └── main/
│       └── java/
│           └── contadorpalabras/
│               └── ContadorPalabras.java
│
├── pom.xml
├── README.md
└── target/
    └── ContadorPalabras.jar
```

## Solución de Problemas

### Error: "No se encuentra la clase principal"
- Verificar que el `<mainClass>` en pom.xml esté correcto
- Asegurar que incluye el paquete: `contadorpalabras.ContadorPalabras`

### Error: "NumberFormatException"
- Los datos de entrada deben ser números válidos
- Verificar que estén separados por espacios

### El pipe no funciona en Windows
- Usar PowerShell o CMD con sintaxis correcta
- En PowerShell: `java -jar aleatorio.jar | java -jar ContadorPalabras.jar`

## Autor

Usuario1

## Licencia

Este proyecto es de código abierto y está disponible para uso educativo.

## Notas Adicionales

- El programa procesa cada línea independientemente
- Los números deben estar separados por espacios
- Soporta múltiples líneas de entrada
- Ideal para procesamiento en batch o scripts automatizados
- Compatible con Windows, Linux y macOS
