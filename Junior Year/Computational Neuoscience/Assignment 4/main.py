import matplotlib.pyplot as plt
import numpy as np

# Given parameters
g = 0.025e-6  # Conductance in S
E = -65e-3  # Resting membrane potential in V
C = 1e-9  # Capacitance in F

# Time parameters
dt = 0.1e-3  # Msec timestep in sec
T = 300e-3  # Total simulation time in sec
times = np.arange(0, T, dt)  # Array of time points

# List of current injections
Iinject_values = [0, 0.25e-9, 0.3536e-9, 0.5e-9, 0.707e-9, 1e-9, 1.41e-9]

plt.figure(figsize=(10, 6))

for Iinject in Iinject_values:
    Vm = E # Start Vm at rest potential
    membrane_potentials = [Vm] # Create list with one membrane potential at rest

    for t in times[1:]: # For loop for all time values
        # Check if the current time t is within 150msec to 300msec
        if 150e-3 <= t <= 300e-3: #If-else to drop Iinject to 0 after 150msec
            current_Iinject = 0
        else:
            current_Iinject = Iinject

        dVm_dt = ((-(g)*(Vm-E)) + current_Iinject) / C #Basic Equation

        Vm += dVm_dt * dt #New membrane potential based off of previous and dt
        membrane_potentials.append(Vm)

    plt.plot(times, [V * 1e3 for V in membrane_potentials], label=f'Iinject = {Iinject * 1e9:.2f} nA')

plt.xlabel('Time (s)')
plt.ylabel('Membrane Potential (mV)')
plt.title('Membrane Potential vs Time for different Iinject values')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()
