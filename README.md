# Yocto layer for orange-pi-one

This layer demoonstrates the following board functionality:

* Run with linux kernel v4.20
* Weston with egl support
* glmark2-es2-wayland utilizing MALI-400 hardware acceleration

Heatsink and fan should be install before run glmark or any other power intensive tools, otherwise you can get cpu reboot

### The Build Host Packages
* Ubuntu and Debian
``` 
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm
```
### Expected directory structure
- build_dir
    - meta-opi
    - oe-core
    - oe-core/bitbake
    - meta-openembedded

### How to build
* Clone repositories first
```
    mkdir build_dir && cd build_dir
    git clone git://github.com/devel-opi/meta-opi.git
    git clone git://git.openembedded.org/openembedded-core oe-core
    git clone git://git.openembedded.org/bitbake oe-core/bitbake
    git clone git://git.openembedded.org/meta-openembedded
```
* Create/Activate bitbake environment
```
    source oe-core/oe-init-build-env
```
After that you should be moved into newly created "./build" folder
    
* Configure build
```
    cat ../meta-opi/bblayers.frag >> ./conf/bblayers.conf
    cat ../meta-opi/conf.frag >> ./conf/local.conf
```
* Start build (can take a couple of hours)
```
    bitbake core-image-minimal
```
    
After successful build, you can find image for SD-Card at **build_dir/build/tmp-glibc/deploy/images/orange-pi-one**

You can write it into SD-Card using **dd** utility
