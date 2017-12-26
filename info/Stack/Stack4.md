# 仅使用递归函数和栈逆序一个栈

### 题目

宠物，猫狗的类如下：

    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }


### 要求

实现一种猫狗队列结构，要求如下：

  - 用户可以调用add方法将cat类和dog类的实例放入队列中

  - 用户可以调用pollAll方法，将队列中所有实例按照进队列的先后顺序依次弹出

  - 用户可以调用pollDog方法，将队列中的dog类的实例按照进队的先后顺序依次弹出

  - 用户可以调用pollCat方法，将队列中的cat类的实例按照进队的先后顺序依次弹出

  - 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例

  - 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例

  - 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例

### 难度

 ★ ☆ ☆ ☆

### 代码

 [Java源码实现](../../src/Stack/Stack4.java)
