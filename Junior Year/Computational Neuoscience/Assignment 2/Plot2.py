import matplotlib.pyplot as plt

def plot_step_response(input_signal, output_signal):
    # Create a figure and axis
    fig, ax = plt.subplots()

    # Plot the step response
    ax.plot(input_signal, label='Input Signal')
    ax.plot(output_signal, label='Output Signal', linestyle='--')

    # Add labels and title
    ax.set_xlabel('Time Steps')
    ax.set_ylabel('Amplitude')
    ax.set_title('Step Response')
    ax.legend()

    # Display the plot
    plt.show()

# Input and Output data
input_signal = [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
output_signal = [-0.4, -3.1, -4.7, 3.1, 10.2, 3.1, -4.7, -3.1, -0.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

# Call the function to plot the step response
plot_step_response(input_signal, output_signal)
