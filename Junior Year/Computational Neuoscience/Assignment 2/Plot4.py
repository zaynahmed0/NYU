import numpy as np
import matplotlib.pyplot as plt

# Define the parameters
N = 100  # Number of points
n = np.arange(N)  # n values

# Define different k values (frequencies)
k_values = [1, 2, 3, 4, 5]

# Create a figure and axes for plotting
fig, axs = plt.subplots(len(k_values), 2, figsize=(10, 10))

for idx, k in enumerate(k_values):
    # Compute the sinusoidal input sequence
    input_signal = np.sin(2 * np.pi * k * n / N)

    # Here, we'll assume the output is a sinusoid with the same phase as the input.
    # If there's a specific system you're passing the signal through, you would compute the output signal accordingly.
    output_signal = input_signal  # Replace this line with the computation of your output signal

    # Plot the input signal
    axs[idx, 0].plot(n, input_signal)
    axs[idx, 0].set_title(f'Input Signal (k={k})')

    # Plot the output signal
    axs[idx, 1].plot(n, output_signal)
    axs[idx, 1].set_title(f'Output Signal (k={k})')

# Adjust spacing and save the plot as an image file
plt.tight_layout()
plt.savefig('output_plot.png')  # Saves the plot as 'output_plot.png' in the current directory

# Optionally, you can also display the plot
# plt.show()
