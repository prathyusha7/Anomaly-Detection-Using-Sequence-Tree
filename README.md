# Anomaly-Detection-Using-Sequence-Tree
A sequence is a series of successive commands executed by a user during an SSH-Session. The sequence is beginning with the input of a command and ends if the user repeats this command or if the length of the series has reached a given threshold. These sequences can be stored in sequence trees. To create sequence trees, the system scans all executed commands. For each of the commands used during an SSH session, a sequence tree is created.
This approach is not based on any probability measure. Instead of this, the system is looking for known command sequences in sequence trees. The average depth reached in all sequence tree searches is a measure to detect anomalous behaviour.

We give an example to illustrate this approach. 

The sequence “cd - ls - cp -joe” reaches the depth 3.
 Sequence “cd - cp - joe” reaches depth 0 (the depth of the root is defined as 0). 

The system calculates the average depth of all sequence trees, not only the average depth of the current used sequence tree.  A low average acts as an indicator for anomalous behaviour. The behaviour is treated as anomalous behaviour if the average depth is lower than a given threshold value.
