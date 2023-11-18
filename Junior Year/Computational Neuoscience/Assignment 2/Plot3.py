import numpy as np
import matplotlib.pyplot as plt

# Define the parameters
N = 100  # Number of points

# Define a range of k values (frequencies)
k_values = np.arange(1, 21)  # k values from 1 to 20

# Assume the output amplitude is constant at 1.0 for all k values
# Replace this line with the computation of your output amplitude if you have a specific system
output_amplitude = np.ones_like(k_values)  # Creates an array of ones with the same shape as k_values

# Plot the output amplitude as a function of the input frequency k
plt.figure(figsize=(10, 5))
plt.plot(k_values, output_amplitude, marker='o')
plt.title('Output Amplitude as a Function of Input Frequency (k)')
plt.xlabel('Input Frequency (k)')
plt.ylabel('Output Amplitude')
plt.grid(True)
plt.savefig('amplitude_vs_frequency.png')  # Saves the plot as 'amplitude_vs_frequency.png' in the current directory

# Optionally, you can also display the plot
# plt.show()
