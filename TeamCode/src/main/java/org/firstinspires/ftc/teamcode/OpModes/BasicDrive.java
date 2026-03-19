package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.MotorEx;

@TeleOp
public class BasicDrive extends NextFTCOpMode {
    public BasicDrive() {
        addComponents(BulkReadComponent.INSTANCE, BindingsComponent.INSTANCE);
    }

    private final MotorEx frontLeftMotor = new MotorEx("frontLeft").reversed();
    private final MotorEx frontRightMotor = new MotorEx("frontRight");
    private final MotorEx backLeftMotor = new MotorEx("backLeft").reversed();
    private final MotorEx backRightMotor = new MotorEx("backRight");

    @Override
    public void onStartButtonPressed() {
        Command driverControlled = new MecanumDriverControlled(
                frontLeftMotor,
                frontRightMotor,
                backLeftMotor,
                backRightMotor,
                Gamepads.gamepad1().leftStickY(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX()
        );
        driverControlled.schedule();

    }
}
