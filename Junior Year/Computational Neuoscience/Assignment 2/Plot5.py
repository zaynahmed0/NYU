import numpy as np
import matplotlib.pyplot as plt

# Define the parameters
N = 100  # Number of points
n = np.arange(N)  # n values
k = 3  # Chosen frequency value

# Compute the sinusoidal input sequence
input_signal = np.sin(2 * np.pi * k * n / N)

# Assume the output is a sinusoid with the same phase as the input
# Replace this line with the computation of your output signal if you have a specific system
output_signal = input_signal

# Create a new (co-)sinusoidal signal with adjustable amplitude and phase to match the output signal
# Initial guesses for amplitude and phase
amplitude_guess = 1.0
phase_guess = 0.0
new_signal = amplitude_guess * np.cos(2 * np.pi * k * n / N + phase_guess)

# Plot the output signal and the new (co-)sinusoidal signal on the same graph
plt.figure(figsize=(10, 5))
plt.plot(n, output_signal, label='Output Signal')
plt.plot(n, new_signal, linestyle='dashed', label='New (Co-)Sinusoidal Signal')
plt.legend()
plt.title('Superimposed Output Signal and New (Co-)Sinusoidal Signal')
plt.xlabel('n')
plt.ylabel('Amplitude')
plt.grid(True)
plt.savefig('superimposed_plot.png')  # Saves the plot as 'superimposed_plot.png' in the current directory

# Optionally, you can also display the plot
# plt.show()
