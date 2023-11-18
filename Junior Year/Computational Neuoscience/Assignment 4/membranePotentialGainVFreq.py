import numpy as np
import matplotlib.pyplot as plt

# Given parameters
g = 0.01e-6  # Conductance in S
R = 1/g  # Resistance in ohms
C = 0.1e-9  # Capacitance in F

# Frequency range
frequencies = np.geomspace(1/4, 64, num=500)  # Geometrically spaced frequencies from 1/4 Hz to 64 Hz

# Calculate Gain for each frequency
gain = 1 / np.sqrt(1 + (2 * np.pi * frequencies * R * C)**2)

# Convert Gain from V/A to mV/nA
gain_mV_per_nA = gain * 1e3

# Plot Gain vs Frequency
plt.figure(figsize=(10, 6))
plt.plot(frequencies, gain_mV_per_nA, label='Gain')
plt.xscale('log')
plt.xlabel('Frequency (Hz)')
plt.ylabel('Gain (mV/nA)')
plt.title('Gain (mV/nA) vs Frequency (Hz)')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()