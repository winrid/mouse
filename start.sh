
#!/bin/bash

sudo cp mouse.service /etc/systemd/system/
sudo systemctl enable mouse
sudo systemctl restart mouse
