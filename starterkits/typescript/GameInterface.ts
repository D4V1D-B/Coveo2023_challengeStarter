export interface Vector {
  x: number;
  y: number;
}

export interface Projectile {
  id: string;
  position: Vector;
  velocity: Vector;
  size: number;
}

export interface Meteor extends Projectile {
  meteorType: MeteorType;
}

export enum ActionTypes {
  ROTATE = 'ROTATE',
  LOOKAT = 'LOOKAT',
  SHOOT = 'SHOOT',
}

export type Action = ActionRotate | ActionLookAt | ActionShoot

export interface ActionRotate extends ActionBase {
  type: ActionTypes.ROTATE;
  angle: number
}

export interface ActionLookAt extends ActionBase {
  type: ActionTypes.LOOKAT;
  target: Vector
}

export interface ActionShoot extends ActionBase {
  type: ActionTypes.SHOOT;
}

interface ActionBase {
  type: ActionTypes;
}

export enum MeteorType {
    Large = "LARGE",
    Medium = "MEDIUM",
    Small = "SMALL",
    Debug = "DEBUG",
}

export interface MeteorInfos {
  score: number;
  size: number;
  approximateSpeed: number;
  explodesInto: {
      meteorType: MeteorType;
      approximateAngle: number;
  }[];
}

export interface GameTick {
  tick: number,
  constants: {
    world: {
      width: number;
      height: number;
    }
    rockets: {
      speed: number;
      size: number;
    },
    cannonCooldownTicks: number,
    meteorInfos: {[k in MeteorType]: MeteorInfos}
  },
  lastTickErrors: string[];
  cannon: {
    position: Vector;
    orientation: number;
    cooldown: number;
  };
  meteors: Meteor[];
  rockets: Projectile[];
  score: number;
}


export class GameMessage implements GameTick {
  public readonly constants: {
    world: {
      width: number;
      height: number;
    }
    cannonCooldownTicks: number,
    rockets: {
      speed: number;
      size: number;
    }
    meteorInfos: {[k in MeteorType]: MeteorInfos}
  };
  public readonly tick: number;
  public readonly lastTickErrors: string[];
  public readonly ;
  public readonly cannon: {
    position: Vector;
    orientation: number;
    cooldown: number;
  };
  public readonly cannonCooldown: number;
  public readonly meteors: Meteor[];
  public readonly rockets: Projectile[];
  public readonly score: number;

  constructor(rawTick: GameTick) {
    Object.assign(this, rawTick);
  }
}
