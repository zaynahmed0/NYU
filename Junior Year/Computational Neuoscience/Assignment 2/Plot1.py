import numpy as np
import matplotlib.pyplot as plt
import os

# Define the sequence length N
N = 32

# Compute the frequencies using the formula: 2 * pi * k / N
k_values = np.arange(-N / 2, N / 2 + 1)
frequencies = 2 * np.pi * k_values / N

# Generate the time values t over which the sinusoids and cosinusoids will be evaluated
t = np.arange(N)

# Generate sinusoids and cosinusoids for the computed frequencies
waveforms = [(np.sin(frequencies[i] * t), np.cos(frequencies[i] * t)) for i in range(len(frequencies))]


output_directory = "./"

# Selected indices for visualization
selected_indices = [0, 8, 16, 24, 31]

# For each selected index, plot the corresponding sinusoid and cosinusoid and save them as separate image files
for index in selected_indices:
    plt.figure(figsize=(6, 4))
    plt.plot(t, waveforms[index][0])
    plt.title(f'sin(2π{k_values[index]}/N)')
    sin_filename = os.path.join(output_directory, f'sin_2pi_{k_values[index]}_over_N.png')
    plt.savefig(sin_filename)
    plt.close()

    plt.figure(figsize=(6, 4))
    plt.plot(t, waveforms[index][1])
    plt.title(f'cos(2π{k_values[index]}/N)')
    cos_filename = os.path.join(output_directory, f'cos_2pi_{k_values[index]}_over_N.png')
    plt.savefig(cos_filename)
    plt.close()
