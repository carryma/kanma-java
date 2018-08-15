package com.kanma.classloader;

public class ClassLoaderTree {

	public static void main(String[] args) {
		// 获取该类的类加载器
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
	}
}
