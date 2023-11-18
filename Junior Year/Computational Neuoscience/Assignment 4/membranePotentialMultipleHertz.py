import matplotlib.pyplot as plt
import numpy as np

# Given parameters
g = 0.025e-6  # Conductance in S
E = -65e-3  # Resting membrane potential in V
C = 0.5e-9  # Capacitance in F

# Time parameters
dt = 0.1e-3  # Msec timestep in sec
T = 300e-3  # Total simulation time in sec
times = np.arange(0, T, dt)  # Array of time points

# Single Iinject value
Iinject = 1.00e-9

# List of frequencies
frequencies = [4, 16, 32, 64]

plt.figure(figsize=(10, 6))

for freq in frequencies:
    Vm = E # Start Vm at rest potential
    membrane_potentials = [Vm] # Create list with one membrane potential at rest

    for t in times[1:]: # For loop for all time values
        # Make the current injection vary sinusoidally over time with the given frequency
        current_Iinject = Iinject * np.sin(2 * np.pi * freq * t)

        dVm_dt = ((-(g)*(Vm-E)) + current_Iinject) / C #Basic Equation

        Vm += dVm_dt * dt #New membrane potential based off of previous and dt
        membrane_potentials.append(Vm)

    plt.plot(times, [V * 1e3 for V in membrane_potentials], label=f'Frequency = {freq} Hz')

plt.xlabel('Time (s)')
plt.ylabel('Membrane Potential (mV)')
plt.title('Membrane Potential vs Time for different frequencies with Iinject = 1.00 nA')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()
