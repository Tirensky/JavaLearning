# [Коллекции](https://github.com/Tirensky/JavaLearning/tree/master/Collections/src)
В стандартной библиотеке Java содержиться множество различных коллекции. И для понимания, чем каждая отличается друг от друга и как они устроены изнутри, я воссоздал некоторые коллекции в простом виде.
Для их изучения был выбран разбор тематической задачи "Система учёта автомобилей".

>  *Проект был создан с использованием системы сборки gradle и библиотеки JUnit5*

### Задача
Написать систему учёта автомобилей. Согласно требованию, нужен класс, который будет описывать авто и класс, который будет хранить в себе объекты этого (и любого другого) типа - то есть систему.

**На первое время система должна реализовывать:**
- получение информации об автомобиле по индексу и их количество
- добавление нового автомобиля в указанную позицию списка
- удаление из списка по элементу и по индексу
- удаление всех данных из списка
- при любом обращении к индексу, который находится за пределами коллекции, необходимо бросить соответствующее исключение

Исходя из этого, создадим класс **Car**, объекты которого будут храниться в кастомной коллекции 

## Описание класса Car

package `base`

`public class Car`..  
implements `Comparable<Car>`

| Конструктор                     | Описание                                                |
| --------------------------------|:--------------------------------------------------------|
| Car(String brand, int serialID) | Создает сущность `Car` с заданной маркой и номером авто |


| Поле/Метод                     | Описание           |
| -------------------------------|:-------------------|
| String brand                   | Марка автомобиля   |
| int serialID                   | Номер автомобиля   |
| String getBrand()              | Возвращает марку авто  |
| void setBrand(String brand)    | Изменяет марку авто    |
| int getSerialID()              | Возвращает номера авто |
| void setSerialID(int serialID) | Измененяет номера авто |
| *@Override* String toString()            | Возвращает информацию о классе `Car` |
| *@Override* boolean equals(Object obj)   | Указывает, "равен" ли другой объект `Car` этому объекту |
| *@Override* int hashCode()               | Возвращает числовое представление объекта |
| *@Override* int compareTo(Car o)         | Возвращает результат сравнения марки авто другого объекта с этим. Используется для сортировки |
| static Comparator\<Car\> compareById() | Возвращает результат сравнения номера авто. Используется для сортировки на основе этого атрибута |

Теперь реализуем систему учёта на уровне абстракции. Напишем интерфейс, в котором мы объявим все необходимые методы, описывая то, что должна делать эта система.

## Описание интерфейса JList

            JList<E>
            
package `base.collection`

`public interface JList<E>`..  
extends `JCollection<E>`

| Метод                       | Описание                                                   |
| ----------------------------|:-----------------------------------------------------------|
| E get(int index)            | Возвращает элемент в указанной позиции в списке            |
| boolean add(E e)            | Вcегда возвращает `true`. Добавляет указанный элемент в конец списка |
| boolean add(E e, int index) | Всегда возвращает `true`. Добавляет указанный элемент в указанную позицию списка  |
| boolean remove(E e)         | Возвращает `true` если элемент был найден в списке, удаляет первое вхождение указанного элемента из списка |
| boolean remove(int index)   | Возвращает `true` или `IndexOutOfBoundsException()` если индекс меньше 0 или больше или равен размеру списка. Удаляет элемент в указанной позиции в списке |
| int size()                  | Возвращает количество элементов в списке |
| void clear()                | Удаляет все элементы из списка           |

Перед тем как приступить к реализации, лучше сначала написать тесты на интерфейс, а затем подставить нашу реализацию и проверить, что все тесты проходятся успешно. Такой подход к программированию называется Test Driven Development (TDD).

**Нужно проверить**   
- Получение элемента
- Выброс исключения IndexOutOfBoundException при получении/удалении ошибочного, несуществующего элемента
- Добавление N-ного кол-ва элементов в список и увеличение его размера на такое же кол-во
- Добавление элемента в начало/середину/конец списка
- Успешное удаление существующего элемента (также по индексу) при котором происходит уменьшение размера списка 
- Удаление несуществующего элемента не должно уменьшать размер списка
- После очистки списка его размер должен быть равен 0
- Успешный/неуспешный поиск элемента в списке
- Перебор элементов в цикле foreach (доп сложность)

Как только все тесты будут написаны, напишем коллекцию `JArrayList`, которая является копией уже существующего `ArrayList` 

## Описание класса JArrayList

            JList<E>
            /
        JArrayList<E>

package `base.collection`

`public class JArrayList<E>`..  
implements `JList<E>`

| Конструктор       | Описание                                         |
| ------------------|:-------------------------------------------------|
| JArrayList()      | Создает пустую коллекцию с начальной ёмкостью 10 |

| Поле/Метод                | Описание                                   |
| --------------------------|:-------------------------------------------|
| Object[] array            | Внутренний массив элементов типа `Object`  |
| int size                  | Размер коллекции                           |
| void setDefaultValues()   | Устанавливает значения полей `array` и `size` по умолчанию: размер внутреннего массива равен 10, размер коллекции 0 |
| E get(int index)                              | Возвращает элемент в указанной позиции в коллекции                                              |
| void checkIndex(int index, boolean condition) | Выбрасывает `IndexOutOfBoundsException()`. Проверяет индекс элемента в коллекции: если `index` меньше 0 или `condition` равен `false`  |
| boolean add(E e)                              | Вcегда возвращает `true`. Добавляет указанный элемент в конец коллекции |
| void growOnFill(int index)    | Увеличивает ёмкость массива если размер коллекции больше или равен размеру массива    |
| boolean add(E e, int index)   | Всегда возвращает `true`. Добавляет указанный элемент в указанную позицию коллекции   |
| boolean remove(E e)           | Возвращает `true`, если элемент был найден в коллекции, удаляет первое вхождение указанного элемента из коллекции |
| boolean remove(int index)     | Возвращает `true` или `IndexOutOfBoundsException()` если индекс меньше 0 или больше или равен размеру коллекции. Удаляет элемент в указанной позиции в коллекции |
| int findElement(E e)          | Возвращает индекс элемента или -1 если он не найден в коллекции |
| boolean contains(E e)         | Возвращает `true` или `false` если коллекция содержит указанный элемент   |
| int size()                    | Возвращает количество элементов в коллекции |
| void clear()                  | Удаляет все элементы из коллекции |
| *@Override* String toString() | Возвращает информацию о коллекции |
| *@Override* Iterator<E> iterator()      | Возвращает перебор (итератор) по элементам в этой коллекции в правильной последовательности  |

Как стало понятно, в основе такой коллекции лежит массив. Использование такой коллекции имеет несколько плюсов: быстрое получение и добавление в конец коллекции. 
Но при этом имеет минусы в виде медленного удаления элемента, медленной вставки в середину или начало коллекции. И самый главный минус - утечка памяти.
Возникающая, когда внутренний размер массива не изменяется при удалении элементов. Но есть возможность исправить эти недостатки, создав новый вид коллекции, в основе которой лежит связный список. Назовём его соответствующе `JLinkedList`.

## Описание класса JLinkedList

`JLinkedList` представляет собой двусвязный список, в котором объекты будут хранится не во внутреннем массиве, но каждый элемент этого списка будет хранить ссылки на предыдущий и следующий элементы.
По этим ссылкам можно переходить от одного элемента списка к другому. Также при удалении элемента из него не надо волноваться, что будет происходить утечка памяти как в случае с `JArrayList`. Если объёкт удалён и на него нет ссылок из стэка, им заёмётся сборщик мусора (Garbage Collector - GC). Также из-за того, что этот вид коллекции реализует интерфейс `JList` как и `JArrayList`, то не нужно писать дополнительные тесты. Есть и ещё кое-что о функциях этой коллекции, о чем подробнее будет описано позднее.

            JList<E>
          /         \
    JArrayList<E>   JLinkedList<E>

package `base.collection`

`public class JLinkedList<E>`..  
implements `JList<E>`, `JQueue<E>`

| Конструктор       | Описание                                          |
| ------------------|:--------------------------------------------------|
| JLinkedList()     | Создает пустой список с начальной ёмкостью десять |

| Поле/Метод                | Описание                                  |
| --------------------------|:------------------------------------------|
| Node head | Ссылка на первый элемент коллекции    |
| Node tail | Ссылка на последний элемент коллекции |
| int size  | Размер коллекции                      |
| void setDefaultValues()     | Устанавливает значения полей `head`, `tail` и `size` по умолчанию: ссылка на первый и последний элементы равны `null`, размер коллекции 0 |
| E get(int index)            | Возвращает элемент в указанной позиции в коллекции  |
| Node getNode(int index)     | Возвращает ссылку ветви (`node`) по индексу         |
| boolean add(E e)            | Вcегда возвращает `true`. Добавляет указанный элемент в конец коллекции |
| boolean add(E e, int index) | Всегда возвращает `true`. Добавляет указанный элемент в указанную позицию коллекции |
| boolean remove(E e)         | Возвращает `true` если элемент был найден в коллекции, удаляет первое вхождение указанного элемента из коллекции |
| boolean remove(int index)   | Возвращает `true` или `IndexOutOfBoundsException()`, если индекс меньше 0 или больше или равен размеру коллекции. Удаляет элемент в указанной позиции в коллекции |
| E remove()      | Извлекает первый элемент и удаляет его, либо выбрасывает исключение `NoSuchElementException()` если коллекция пуста |
| E peek()        | Извлекает первый элемент, но не удаляет его, либо возвращает `null`, если коллекция пуста |
| E poll()        | Извлекает первый элемент и удаляет его, либо возвращает `null`, если коллекция пуста |
| int size()      | Возвращает количество элементов в коллекции |
| void clear()    | Удаляет все элементы из коллекции           |
| int findElement(E e)          | Возвращает индекс элемента или -1, если он не найден в коллекции          |
| boolean contains(E e)         | Возвращает `true` или `false`, если коллекция содержит указанный элемент  |
| *@Override* String toString() | Возвращает информацию о коллекции |
| *@Override* Iterator<E> iterator()      | Возвращает перебор (итератор) по элементам в этой коллекции в правильной последовательности  |

### Описание вспомогательного класса **Node**

Внутри нашего класса `JLinkedList` есть ещё один класс - `Node` (или ветвь). В этом классе объект будет хранить в себе ссылку на предыдущий и следующий элементы, а так же текущее значение.

`class Node<E>`

| Конструктор                            | Описание                              |
| ---------------------------------------|:--------------------------------------|
| Node(Node prev, E value, Node next)    | Создает ветвь с заданными параметрами |

| Поле/Метод | Описание                           |
| -----------|:-----------------------------------|
| Node prev  | Ссылка на предыдуший элемент ветви |
| E value    | Значение ветви                     |
| Node next  | ССылка на следующий элемент ветви  |

----

Теперь система учета авто стала всё более совершенной. Написано две реализации: `JArrayList`, в основе которой лежит массив, и `JLinkedList`, в основе которой связный список. Обе реализуют интерфейс `JList`.
Алгоритмическая сложность операции этих коллекций выглядит так:

| Операция                                  | JArrayList | JLinkedList |
| ----------------------------------------- |:----------:|:-----------:|
| Получение элемента по индексу             |    O(1)    |     O(N)    | 
| Вставка элемента в конец списка           |    O(1)    |     O(1)    |
| Вставка элемента в начало/середину списка |    O(N)    |     O(1)    |
| Удаление элемента по индексу              |    O(N)    |     O(1)    |

Отсюда делаем выводы:

- Если нужно часто удалять элементы из коллекции или часто вставлять объекты в начало/середину списка, то лучше использовать `LinkedList` - встроенную в Java коллекцию. 
При удалении элементов из этой коллекции память сразу освобождается, а в `ArrayList` - нет.

- Если нужно часто вставлять элементы в конец списка или получать объекты по индексу, то лучше использовать `ArrayList`. 

Теперь эти вопросы не покажутся сложными:

<details> 
  <summary>1. В чем отличие коллекции ArrayList и LinkedList? </summary>
   В основе ArrayList лежит массив, а в основе LinkedList связный список.
</details>
<details> 
  <summary>2. Алгоритмическая сложность получения элемента по индеску у ArrayList и LinkedList? </summary>
   ArrayList - O(1), LinkedList - O(N).
</details>
<details> 
  <summary>3. Алгоритмическая сложность удаление элемента по индеску у ArrayList и LinkedList? </summary>
   ArrayList - O(N), LinkedList - O(1).
</details>
<details> 
  <summary>4. В каких случаях стоит использовать LinkedList вместо ArrayList? </summary>
   Если часто приходится вставлять элементы в середину/начало списка, либо удаление объектов из коллекции происходит часто.
</details>
<details> 
  <summary>5. В ArrayList постоянно добавляются элементы, а также удаляеются из него множество элементов. Какие могут возникнуть проблемы? </summary>
   В этом случае возможна утечка памяти из-за того, что внутренний размер массива не уменьшаяется автоматически при удалении элементов из коллекции.
</details>

----

Теперь стоит задача немного улучшить систему учёта автомобилей. Требуется сделать так, чтобы в одном списке не могло быть двух одинаковых объектов, в нашем случае `Car` - машин, - у которых совпадает марка и номер.
Это значит, что перед добавлением объекта нужно проверить нет ли такого же объекта в коллекции. И если есть, не добавлять новый. Как это будет выглядеть, если будем использовать уже существующие коллекции? 
В методе `add()` будем проходить по всем элементам коллекции и проверять через `equals()` не добавляли ли мы такой объект в коллекцию. Это конечно увеличит сложность добавления с O(1) до O(N).

Поэтому лучше создать отдельный вид коллекции, который не реализует интерфейс `JList` - это интерфейс `JSet`. Коллекции этого типа не могут хранить повторяющиеся элементы.

## Описание интерфейса JSet

            JSet<E>
            
package `base.collection`

`public interface JSet<E>`..   
extends `JCollection<E>`

| Метод                       | Описание                                                   |
| ----------------------------|:-----------------------------------------------------------|
| boolean add(E e)            | Возвращает `true` если добавление прошло успешно, или `false` если похожий элемент уже есть в наборе       |
| boolean remove(E e)         | Возвращает `true` если элемент был найден в наборе, удаляет первое вхождение указанного элемента из набора |
| int size()                  | Возвращает количество элементов в наборе |
| void clear()                | Удаляет все элементы из списка           |

Теперь необходимо протестировать все эти методы. Снова напишем тесты на них.

**Нужно проверить**   
- Добавление только одного элемента если добавляется несколько одинаковых
- Успешное удаление существующего элемента, при котором происходит уменьшение размера набора
- Удаление несуществующего элемента не должно уменьшать размер списка
- После очистки списка его размер должен быть равен 0
- Успешный/неуспешный поиск элемента в списке
- Перебор элементов в цикле foreach (доп сложность)

Как только все тесты будут написаны, напишем коллекцию `EHashSet`, которая является копией уже существующего `HashSet` 

## Описание класса EHashSet

            JSet<E>
            /
        EHashSet<E>

package `base.collection`

`public class EHashSet<E>`..  
implements `JSet<E>`

| Конструктор       | Описание                                         |
| ------------------|:-------------------------------------------------|
| EHashSet()        | Создает пустую коллекцию с начальной ёмкостью 16 |

| Поле/Метод                | Описание                                   |
| --------------------------|:-------------------------------------------|
| Object[] array            | Внутренний массив элементов типа `Object`  |
| int size                  | Размер коллекции                           |
| void setDefaultValues()   | Устанавливает значения полей `array` и `size` по умолчанию: размер внутреннего массива равен 16, размер коллекции 0 |
| int getElementPosition(E e, int arrLength) | Возвращает индекс элемента в массиве |
| boolean add(E e)          | Возвращает `true` если добавление прошло успешно, или `false` если похожий элемент уже есть в коллекции |
| boolean add(E e, Object[] dest)    | Возвращает `true` если добавление прошло успешно в массив назначения, или `false` если похожий элемент уже есть в коллекции |
| void expandArray()                 | Увеличивает ёмкость массива если размер коллекции больше или равен 75% размера массива |
| boolean remove(E e)                | Возвращает `true` если элемент был найден в наборе, удаляет первое вхождение указанного элемента из коллекции |
| boolean contains(E e)              | Возвращает `true` или `false` если коллекция содержит указанный элемент |
| int size()                         | Возвращает количество элементов в коллекции |
| void clear()                       | Удаляет все элементы из коллекции |
| *@Override* String toString()      | Возвращает информацию о коллекции |
| *@Override* Iterator<E> iterator() | Возвращает перебор (итератор) по элементам в этой коллекции в правильной последовательности |

