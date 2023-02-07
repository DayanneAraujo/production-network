package org.example.sample;

import org.example.sample.domain.Component;
import org.example.sample.domain.ProductionNetwork;
import org.example.sample.domain.Profile;
import org.example.sample.domain.array.ProductionNetworkArray;
import org.example.sample.domain.binarytree.BinaryTreeComponent;
import org.example.sample.domain.binarytree.ProductionNetworkBT;
import org.example.sample.domain.linkedlist.LinkedListComponent;
import org.example.sample.domain.linkedlist.ProductionNetworkLinkedList;
import org.example.sample.infrastructure.ArrayRepo;
import org.example.sample.infrastructure.BinaryTreeRepo;
import org.example.sample.infrastructure.LinkedListRepo;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("==================================================================");
        System.out.println("==========================ARRAY IMPLEMENTATION====================");
        System.out.println("==================================================================");

        final var arrayRepo = new ArrayRepo();
        final var productionNetworkArray= new ProductionNetworkArray();
        
        final Set<Component[]> componentsStructure = arrayRepo.fetchInputComponents();
        final Set<Profile> profiles = productionNetworkArray.getAllProfiles(componentsStructure);

        printProfiles(profiles);

        System.out.println("==================================================================");
        System.out.println("=========================TREE IMPLEMENTATION======================");
        System.out.println("==================================================================");

        final var binaryTreeRepo = new BinaryTreeRepo();
        final var productionNetworkBinaryTree = new ProductionNetworkBT();

        Set<BinaryTreeComponent> binaryTreeRoots = binaryTreeRepo.fetchInputComponents();
        Set<Profile> binaryTreeProfiles = productionNetworkBinaryTree.getAllProfiles(binaryTreeRoots);
        
        printProfiles(binaryTreeProfiles);

        System.out.println("==================================================================");
        System.out.println("======================LINKED LIST IMPLEMENTATION==================");
        System.out.println("==================================================================");
        final var linkedListRepo = new LinkedListRepo();
        final var productionNetworkLinkedList = new ProductionNetworkLinkedList();

        final Set<LinkedListComponent> linkedListHeads = linkedListRepo.fetchInputComponents();
        Set<Profile> linkedListProfiles = productionNetworkLinkedList.getAllProfiles(linkedListHeads);

        printProfiles(linkedListProfiles);
    }

    private static void printProfiles(Set<Profile> profiles) {
        for (Profile profile : profiles) {
            System.out.println(profile);
        }
    }
}
