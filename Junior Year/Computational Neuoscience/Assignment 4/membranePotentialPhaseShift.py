import matplotlib.pyplot as plt
import numpy as np

# Given parameters
g = 0.05e-6  # Conductance in S
E = -65e-3  # Resting membrane potential in V
C = 0.5e-9  # Capacitance in F

# Time parameters
dt = 0.1e-3  # Msec timestep in sec
T = 300e-3  # Total simulation time in sec
times = np.arange(0, T, dt)  # Array of time points

# Current injection value
Iinject_value = 0.5e-9

# Frequency range
frequencies = np.geomspace(1 / 4, 64, num=10)  # Geometrically spaced frequencies from 1/4 Hz to 64 Hz
phase_shifts_degrees = []

for freq in frequencies:
    Vm = E
    membrane_potentials = [Vm]

    for t in times[1:]:
        current_Iinject = Iinject_value * np.sin(2 * np.pi * freq * t)
        dVm_dt = ((-(g) * (Vm - E)) + current_Iinject) / C
        Vm += dVm_dt * dt
        membrane_potentials.append(Vm)

    # Find the time at which the membrane potential reaches its maximum value for the first time
    max_index = np.argmax(membrane_potentials)
    phase_shift_time = times[max_index] % (1 / freq)

    # Convert phase shift in time to phase shift in degrees
    phase_shift_degree = (phase_shift_time / (1 / freq)) * 360
    phase_shifts_degrees.append(phase_shift_degree)

# Plot phase shift in degrees vs frequency
plt.figure(figsize=(10, 6))
plt.plot(frequencies, phase_shifts_degrees, 'o-', label='Phase Shift')
plt.xscale('log')
plt.xlabel('Frequency (Hz)')
plt.ylabel('Phase Shift (degrees)')
plt.title('Phase Shift in Degrees vs Frequency')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()
