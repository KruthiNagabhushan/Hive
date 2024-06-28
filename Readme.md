# Beehive Simulation

This project simulates the day-by-day activities of a beehive over a given period of time. It models the different roles of bees in the colony and their interactions using fundamental concurrency concepts in Java.

## Table of Contents

1. [Introduction](#introduction)
2. [Goals](#goals)
3. [Simulation Details](#simulation-details)
    - [Worker Bee](#worker-bee)
    - [Drone Bee](#drone-bee)
    - [Queen Bee](#queen-bee)
4. [Getting Started](#getting-started)
5. [Contributing](#contributing)
6. [License](#license)

## Introduction

The bees in the beehive are buzzing! A bee in a typical colony has one of three distinct roles:

1. **Queen**: The royal highness of the beehive, responsible for mating with drones and laying eggs.
2. **Worker**: Female bees that gather resources (nectar or pollen) from a field of flowers.
3. **Drone**: Male bees whose sole role is to mate with the queen.

In this project, we will simulate the day-by-day activities of a beehive for a given period using Threads.

## Goals

The goal of this project is to gain experience with fundamental concurrency topics such as:
- Threads
- The Monitor (synchronized regions)
- Thread Control (start vs run, join, sleep)
- Thread Synchronization (wait, notify, notifyAll)

## Simulation Details

### Worker Bee

A worker’s task is to go to the field of flowers and gather one unit of their assigned resource. The field has a limited number of flowers. If there isn’t a free flower, the worker must wait. Once a flower is free, one of the waiting workers will randomly be selected to gather from the free flower. Gathering and depositing a resource into the beehive takes 2 units of time.

### Drone Bee

The task of the drone is to reproduce with the queen by entering the queen’s chamber and lining up first come first served. The queen will mate with the first drone when the conditions are ready. Mating takes 1 unit of time and results in the drone perishing immediately after.

### Queen Bee

The task of the queen is to reproduce with the next waiting drone. It requires the beehive to have at least 1 unit of both nectar and pollen. If the conditions are met, the queen takes the required resources from the beehive and places them into an empty sac. She then mates with the next drone for 1 unit of time, which creates between 1 and 4 new bees (depending on available resources). After each mating, the queen sleeps for 1 unit of time.

## Getting Started

1. Clone the repository:
    ```sh
    git clone https://github.com/KruthiNagabhushan/Hive
    ```

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Run the main class to start the simulation.

