package org.example.jdk8;

import lombok.Data;

import java.util.Optional;

/**
 * 计算机
 */
@Data
class Computer {
    private Optional<SoundCard> soundCard;
}

/**
 * 声卡
 */
@Data
class SoundCard {
    private Optional<Usb> usb;
}

/**
 * USB
 */
@Data
class Usb {
    private String version;
}
