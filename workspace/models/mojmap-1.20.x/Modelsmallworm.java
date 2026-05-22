// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsmallworm<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "smallworm"), "main");
	private final ModelPart main;
	private final ModelPart biter4;
	private final ModelPart carapace4;
	private final ModelPart tete4;
	private final ModelPart p19;
	private final ModelPart p20;
	private final ModelPart p21;
	private final ModelPart p22;
	private final ModelPart p23;
	private final ModelPart p24;
	private final ModelPart pates_avant_gauche4;
	private final ModelPart pates_avant_doite4;
	private final ModelPart pates_milieu_droit4;
	private final ModelPart pates_millieu_gauche4;
	private final ModelPart pates_arriere_gauche4;
	private final ModelPart pates_arriere_doite4;
	private final ModelPart biter3;
	private final ModelPart carapace3;
	private final ModelPart tete3;
	private final ModelPart p13;
	private final ModelPart p14;
	private final ModelPart p15;
	private final ModelPart p16;
	private final ModelPart p17;
	private final ModelPart p18;
	private final ModelPart pates_avant_gauche3;
	private final ModelPart pates_avant_doite3;
	private final ModelPart pates_milieu_droit3;
	private final ModelPart pates_millieu_gauche3;
	private final ModelPart pates_arriere_gauche3;
	private final ModelPart pates_arriere_doite3;
	private final ModelPart biter2;
	private final ModelPart carapace2;
	private final ModelPart tete2;
	private final ModelPart p7;
	private final ModelPart p8;
	private final ModelPart p9;
	private final ModelPart p10;
	private final ModelPart p11;
	private final ModelPart p12;
	private final ModelPart pates_avant_gauche2;
	private final ModelPart pates_avant_doite2;
	private final ModelPart pates_milieu_droit2;
	private final ModelPart pates_millieu_gauche2;
	private final ModelPart pates_arriere_gauche2;
	private final ModelPart pates_arriere_doite2;
	private final ModelPart biter;
	private final ModelPart carapace;
	private final ModelPart tete;
	private final ModelPart p1;
	private final ModelPart p2;
	private final ModelPart p3;
	private final ModelPart p4;
	private final ModelPart p5;
	private final ModelPart p6;
	private final ModelPart pates_avant_gauche;
	private final ModelPart pates_avant_doite;
	private final ModelPart pates_milieu_droit;
	private final ModelPart pates_millieu_gauche;
	private final ModelPart pates_arriere_gauche;
	private final ModelPart pates_arriere_doite;

	public Modelsmallworm(ModelPart root) {
		this.main = root.getChild("main");
		this.biter4 = this.main.getChild("biter4");
		this.carapace4 = this.biter4.getChild("carapace4");
		this.tete4 = this.carapace4.getChild("tete4");
		this.p19 = this.carapace4.getChild("p19");
		this.p20 = this.carapace4.getChild("p20");
		this.p21 = this.carapace4.getChild("p21");
		this.p22 = this.carapace4.getChild("p22");
		this.p23 = this.carapace4.getChild("p23");
		this.p24 = this.carapace4.getChild("p24");
		this.pates_avant_gauche4 = this.biter4.getChild("pates_avant_gauche4");
		this.pates_avant_doite4 = this.biter4.getChild("pates_avant_doite4");
		this.pates_milieu_droit4 = this.biter4.getChild("pates_milieu_droit4");
		this.pates_millieu_gauche4 = this.biter4.getChild("pates_millieu_gauche4");
		this.pates_arriere_gauche4 = this.biter4.getChild("pates_arriere_gauche4");
		this.pates_arriere_doite4 = this.biter4.getChild("pates_arriere_doite4");
		this.biter3 = this.main.getChild("biter3");
		this.carapace3 = this.biter3.getChild("carapace3");
		this.tete3 = this.carapace3.getChild("tete3");
		this.p13 = this.carapace3.getChild("p13");
		this.p14 = this.carapace3.getChild("p14");
		this.p15 = this.carapace3.getChild("p15");
		this.p16 = this.carapace3.getChild("p16");
		this.p17 = this.carapace3.getChild("p17");
		this.p18 = this.carapace3.getChild("p18");
		this.pates_avant_gauche3 = this.biter3.getChild("pates_avant_gauche3");
		this.pates_avant_doite3 = this.biter3.getChild("pates_avant_doite3");
		this.pates_milieu_droit3 = this.biter3.getChild("pates_milieu_droit3");
		this.pates_millieu_gauche3 = this.biter3.getChild("pates_millieu_gauche3");
		this.pates_arriere_gauche3 = this.biter3.getChild("pates_arriere_gauche3");
		this.pates_arriere_doite3 = this.biter3.getChild("pates_arriere_doite3");
		this.biter2 = this.main.getChild("biter2");
		this.carapace2 = this.biter2.getChild("carapace2");
		this.tete2 = this.carapace2.getChild("tete2");
		this.p7 = this.carapace2.getChild("p7");
		this.p8 = this.carapace2.getChild("p8");
		this.p9 = this.carapace2.getChild("p9");
		this.p10 = this.carapace2.getChild("p10");
		this.p11 = this.carapace2.getChild("p11");
		this.p12 = this.carapace2.getChild("p12");
		this.pates_avant_gauche2 = this.biter2.getChild("pates_avant_gauche2");
		this.pates_avant_doite2 = this.biter2.getChild("pates_avant_doite2");
		this.pates_milieu_droit2 = this.biter2.getChild("pates_milieu_droit2");
		this.pates_millieu_gauche2 = this.biter2.getChild("pates_millieu_gauche2");
		this.pates_arriere_gauche2 = this.biter2.getChild("pates_arriere_gauche2");
		this.pates_arriere_doite2 = this.biter2.getChild("pates_arriere_doite2");
		this.biter = this.main.getChild("biter");
		this.carapace = this.biter.getChild("carapace");
		this.tete = this.carapace.getChild("tete");
		this.p1 = this.carapace.getChild("p1");
		this.p2 = this.carapace.getChild("p2");
		this.p3 = this.carapace.getChild("p3");
		this.p4 = this.carapace.getChild("p4");
		this.p5 = this.carapace.getChild("p5");
		this.p6 = this.carapace.getChild("p6");
		this.pates_avant_gauche = this.biter.getChild("pates_avant_gauche");
		this.pates_avant_doite = this.biter.getChild("pates_avant_doite");
		this.pates_milieu_droit = this.biter.getChild("pates_milieu_droit");
		this.pates_millieu_gauche = this.biter.getChild("pates_millieu_gauche");
		this.pates_arriere_gauche = this.biter.getChild("pates_arriere_gauche");
		this.pates_arriere_doite = this.biter.getChild("pates_arriere_doite");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(),
				PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition biter4 = main.addOrReplaceChild("biter4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition carapace4 = biter4.addOrReplaceChild("carapace4", CubeListBuilder.create(),
				PartPose.offset(-1.0F, -1.8F, -3.4F));

		PartDefinition tete4 = carapace4.addOrReplaceChild("tete4", CubeListBuilder.create(),
				PartPose.offset(1.0F, 0.3355F, -1.4096F));

		PartDefinition carapace_r1 = tete4.addOrReplaceChild("carapace_r1",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.1645F, 0.4096F, 0.0F, -0.9599F, 0.6109F));

		PartDefinition carapace_r2 = tete4.addOrReplaceChild("carapace_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.1645F, 0.4096F, 0.0F, 0.9599F, -0.6109F));

		PartDefinition p19 = carapace4.addOrReplaceChild("p19", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition carapace_r3 = p19
				.addOrReplaceChild("carapace_r3",
						CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
								new CubeDeformation(0.3F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r4 = p19.addOrReplaceChild("carapace_r4",
				CubeListBuilder.create().texOffs(12, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p20 = carapace4.addOrReplaceChild("p20", CubeListBuilder.create(),
				PartPose.offset(2.0F, -0.5F, 2.6F));

		PartDefinition carapace_r5 = p20.addOrReplaceChild("carapace_r5",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r6 = p20.addOrReplaceChild("carapace_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p21 = carapace4.addOrReplaceChild("p21", CubeListBuilder.create(),
				PartPose.offset(1.0F, -0.4868F, 4.2F));

		PartDefinition carapace_r7 = p21.addOrReplaceChild("carapace_r7",
				CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r8 = p21.addOrReplaceChild("carapace_r8",
				CubeListBuilder.create().texOffs(10, 9).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p22 = carapace4.addOrReplaceChild("p22", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.0F, 5.9F));

		PartDefinition carapace_r9 = p22.addOrReplaceChild("carapace_r9",
				CubeListBuilder.create().texOffs(10, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r10 = p22.addOrReplaceChild("carapace_r10",
				CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p23 = carapace4.addOrReplaceChild("p23", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.3F, 7.4F));

		PartDefinition carapace_r11 = p23.addOrReplaceChild("carapace_r11",
				CubeListBuilder.create().texOffs(0, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r12 = p23.addOrReplaceChild("carapace_r12",
				CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p24 = carapace4.addOrReplaceChild("p24", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 0.3132F, 8.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition carapace_r13 = p24.addOrReplaceChild("carapace_r13",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r14 = p24.addOrReplaceChild("carapace_r14",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition pates_avant_gauche4 = biter4.addOrReplaceChild("pates_avant_gauche4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r1 = pates_avant_gauche4.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_avant_doite4 = biter4.addOrReplaceChild("pates_avant_doite4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = pates_avant_doite4.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(2, 1).mirror()
						.addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_milieu_droit4 = biter4.addOrReplaceChild("pates_milieu_droit4", CubeListBuilder.create(),
				PartPose.offset(-1.8348F, 0.9276F, -0.9654F));

		PartDefinition cube_r3 = pates_milieu_droit4.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(4, 17).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_millieu_gauche4 = biter4.addOrReplaceChild("pates_millieu_gauche4",
				CubeListBuilder.create(), PartPose.offset(2.2619F, 0.9276F, -0.5F));

		PartDefinition cube_r4 = pates_millieu_gauche4.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(4, 17).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_gauche4 = biter4.addOrReplaceChild("pates_arriere_gauche4",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5076F, 0.046F, 2.9857F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r5 = pates_arriere_gauche4.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(10, 13).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_doite4 = biter4.addOrReplaceChild("pates_arriere_doite4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.4627F, -0.0209F, 3.1534F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r6 = pates_arriere_doite4.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0723F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition biter3 = main.addOrReplaceChild("biter3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition carapace3 = biter3.addOrReplaceChild("carapace3", CubeListBuilder.create(),
				PartPose.offset(-1.0F, -1.8F, -3.4F));

		PartDefinition tete3 = carapace3.addOrReplaceChild("tete3", CubeListBuilder.create(),
				PartPose.offset(1.0F, 0.3355F, -1.4096F));

		PartDefinition carapace_r15 = tete3.addOrReplaceChild("carapace_r15",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.1645F, 0.4096F, 0.0F, -0.9599F, 0.6109F));

		PartDefinition carapace_r16 = tete3.addOrReplaceChild("carapace_r16",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.1645F, 0.4096F, 0.0F, 0.9599F, -0.6109F));

		PartDefinition p13 = carapace3.addOrReplaceChild("p13", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition carapace_r17 = p13
				.addOrReplaceChild("carapace_r17",
						CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
								new CubeDeformation(0.3F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r18 = p13.addOrReplaceChild("carapace_r18",
				CubeListBuilder.create().texOffs(12, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p14 = carapace3.addOrReplaceChild("p14", CubeListBuilder.create(),
				PartPose.offset(2.0F, -0.5F, 2.6F));

		PartDefinition carapace_r19 = p14.addOrReplaceChild("carapace_r19",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r20 = p14.addOrReplaceChild("carapace_r20",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p15 = carapace3.addOrReplaceChild("p15", CubeListBuilder.create(),
				PartPose.offset(1.0F, -0.4868F, 4.2F));

		PartDefinition carapace_r21 = p15.addOrReplaceChild("carapace_r21",
				CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r22 = p15.addOrReplaceChild("carapace_r22",
				CubeListBuilder.create().texOffs(10, 9).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p16 = carapace3.addOrReplaceChild("p16", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.0F, 5.9F));

		PartDefinition carapace_r23 = p16.addOrReplaceChild("carapace_r23",
				CubeListBuilder.create().texOffs(10, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r24 = p16.addOrReplaceChild("carapace_r24",
				CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p17 = carapace3.addOrReplaceChild("p17", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.3F, 7.4F));

		PartDefinition carapace_r25 = p17.addOrReplaceChild("carapace_r25",
				CubeListBuilder.create().texOffs(0, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r26 = p17.addOrReplaceChild("carapace_r26",
				CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p18 = carapace3.addOrReplaceChild("p18", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 0.3132F, 8.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition carapace_r27 = p18.addOrReplaceChild("carapace_r27",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r28 = p18.addOrReplaceChild("carapace_r28",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition pates_avant_gauche3 = biter3.addOrReplaceChild("pates_avant_gauche3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r7 = pates_avant_gauche3.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_avant_doite3 = biter3.addOrReplaceChild("pates_avant_doite3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r8 = pates_avant_doite3.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(2, 1).mirror()
						.addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_milieu_droit3 = biter3.addOrReplaceChild("pates_milieu_droit3", CubeListBuilder.create(),
				PartPose.offset(-1.8348F, 0.9276F, -0.9654F));

		PartDefinition cube_r9 = pates_milieu_droit3.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(4, 17).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_millieu_gauche3 = biter3.addOrReplaceChild("pates_millieu_gauche3",
				CubeListBuilder.create(), PartPose.offset(2.2619F, 0.9276F, -0.5F));

		PartDefinition cube_r10 = pates_millieu_gauche3.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(4, 17).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_gauche3 = biter3.addOrReplaceChild("pates_arriere_gauche3",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5076F, 0.046F, 2.9857F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r11 = pates_arriere_gauche3.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(10, 13).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_doite3 = biter3.addOrReplaceChild("pates_arriere_doite3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.4627F, -0.0209F, 3.1534F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r12 = pates_arriere_doite3.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0723F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition biter2 = main.addOrReplaceChild("biter2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -3.1416F));

		PartDefinition carapace2 = biter2.addOrReplaceChild("carapace2", CubeListBuilder.create(),
				PartPose.offset(-1.0F, -1.8F, -3.4F));

		PartDefinition tete2 = carapace2.addOrReplaceChild("tete2", CubeListBuilder.create(),
				PartPose.offset(1.0F, 0.3355F, -1.4096F));

		PartDefinition carapace_r29 = tete2.addOrReplaceChild("carapace_r29",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.1645F, 0.4096F, 0.0F, -0.9599F, 0.6109F));

		PartDefinition carapace_r30 = tete2.addOrReplaceChild("carapace_r30",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.1645F, 0.4096F, 0.0F, 0.9599F, -0.6109F));

		PartDefinition p7 = carapace2.addOrReplaceChild("p7", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition carapace_r31 = p7
				.addOrReplaceChild("carapace_r31",
						CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
								new CubeDeformation(0.3F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r32 = p7.addOrReplaceChild("carapace_r32",
				CubeListBuilder.create().texOffs(12, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p8 = carapace2.addOrReplaceChild("p8", CubeListBuilder.create(),
				PartPose.offset(2.0F, -0.5F, 2.6F));

		PartDefinition carapace_r33 = p8.addOrReplaceChild("carapace_r33",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r34 = p8.addOrReplaceChild("carapace_r34",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p9 = carapace2.addOrReplaceChild("p9", CubeListBuilder.create(),
				PartPose.offset(1.0F, -0.4868F, 4.2F));

		PartDefinition carapace_r35 = p9.addOrReplaceChild("carapace_r35",
				CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r36 = p9.addOrReplaceChild("carapace_r36",
				CubeListBuilder.create().texOffs(10, 9).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p10 = carapace2.addOrReplaceChild("p10", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.0F, 5.9F));

		PartDefinition carapace_r37 = p10.addOrReplaceChild("carapace_r37",
				CubeListBuilder.create().texOffs(10, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r38 = p10.addOrReplaceChild("carapace_r38",
				CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p11 = carapace2.addOrReplaceChild("p11", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.3F, 7.4F));

		PartDefinition carapace_r39 = p11.addOrReplaceChild("carapace_r39",
				CubeListBuilder.create().texOffs(0, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r40 = p11.addOrReplaceChild("carapace_r40",
				CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p12 = carapace2.addOrReplaceChild("p12", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 0.3132F, 8.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition carapace_r41 = p12.addOrReplaceChild("carapace_r41",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r42 = p12.addOrReplaceChild("carapace_r42",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition pates_avant_gauche2 = biter2.addOrReplaceChild("pates_avant_gauche2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r13 = pates_avant_gauche2.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_avant_doite2 = biter2.addOrReplaceChild("pates_avant_doite2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r14 = pates_avant_doite2.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(2, 1).mirror()
						.addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_milieu_droit2 = biter2.addOrReplaceChild("pates_milieu_droit2", CubeListBuilder.create(),
				PartPose.offset(-1.8348F, 0.9276F, -0.9654F));

		PartDefinition cube_r15 = pates_milieu_droit2.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(4, 17).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_millieu_gauche2 = biter2.addOrReplaceChild("pates_millieu_gauche2",
				CubeListBuilder.create(), PartPose.offset(2.2619F, 0.9276F, -0.5F));

		PartDefinition cube_r16 = pates_millieu_gauche2.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(4, 17).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_gauche2 = biter2.addOrReplaceChild("pates_arriere_gauche2",
				CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5076F, 0.046F, 2.9857F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r17 = pates_arriere_gauche2.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(10, 13).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_doite2 = biter2.addOrReplaceChild("pates_arriere_doite2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.4627F, -0.0209F, 3.1534F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r18 = pates_arriere_doite2.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0723F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition biter = main.addOrReplaceChild("biter", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition carapace = biter.addOrReplaceChild("carapace", CubeListBuilder.create(),
				PartPose.offset(-1.0F, -1.8F, -3.4F));

		PartDefinition tete = carapace.addOrReplaceChild("tete", CubeListBuilder.create(),
				PartPose.offset(1.0F, 0.3355F, -1.4096F));

		PartDefinition carapace_r43 = tete.addOrReplaceChild("carapace_r43",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.1645F, 0.4096F, 0.0F, -0.9599F, 0.6109F));

		PartDefinition carapace_r44 = tete.addOrReplaceChild("carapace_r44",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.1645F, 0.4096F, 0.0F, 0.9599F, -0.6109F));

		PartDefinition p1 = carapace.addOrReplaceChild("p1", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition carapace_r45 = p1
				.addOrReplaceChild("carapace_r45",
						CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
								new CubeDeformation(0.3F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r46 = p1.addOrReplaceChild("carapace_r46",
				CubeListBuilder.create().texOffs(12, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p2 = carapace.addOrReplaceChild("p2", CubeListBuilder.create(),
				PartPose.offset(2.0F, -0.5F, 2.6F));

		PartDefinition carapace_r47 = p2.addOrReplaceChild("carapace_r47",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r48 = p2.addOrReplaceChild("carapace_r48",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p3 = carapace.addOrReplaceChild("p3", CubeListBuilder.create(),
				PartPose.offset(1.0F, -0.4868F, 4.2F));

		PartDefinition carapace_r49 = p3.addOrReplaceChild("carapace_r49",
				CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r50 = p3.addOrReplaceChild("carapace_r50",
				CubeListBuilder.create().texOffs(10, 9).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition p4 = carapace.addOrReplaceChild("p4", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.0F, 5.9F));

		PartDefinition carapace_r51 = p4.addOrReplaceChild("carapace_r51",
				CubeListBuilder.create().texOffs(10, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r52 = p4.addOrReplaceChild("carapace_r52",
				CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p5 = carapace.addOrReplaceChild("p5", CubeListBuilder.create(),
				PartPose.offset(2.0F, 0.3F, 7.4F));

		PartDefinition carapace_r53 = p5.addOrReplaceChild("carapace_r53",
				CubeListBuilder.create().texOffs(0, 5).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r54 = p5.addOrReplaceChild("carapace_r54",
				CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition p6 = carapace.addOrReplaceChild("p6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 0.3132F, 8.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition carapace_r55 = p6.addOrReplaceChild("carapace_r55",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r56 = p6.addOrReplaceChild("carapace_r56",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.0F, 0.2868F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition pates_avant_gauche = biter.addOrReplaceChild("pates_avant_gauche", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r19 = pates_avant_gauche.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_avant_doite = biter.addOrReplaceChild("pates_avant_doite", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.1836F, 0.2864F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r20 = pates_avant_doite.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(2, 1).mirror()
						.addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_milieu_droit = biter.addOrReplaceChild("pates_milieu_droit", CubeListBuilder.create(),
				PartPose.offset(-1.8348F, 0.9276F, -0.9654F));

		PartDefinition cube_r21 = pates_milieu_droit.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(4, 17).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_millieu_gauche = biter.addOrReplaceChild("pates_millieu_gauche", CubeListBuilder.create(),
				PartPose.offset(2.2619F, 0.9276F, -0.5F));

		PartDefinition cube_r22 = pates_millieu_gauche.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(4, 17).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_gauche = biter.addOrReplaceChild("pates_arriere_gauche", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5076F, 0.046F, 2.9857F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r23 = pates_arriere_gauche.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(10, 13).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_doite = biter.addOrReplaceChild("pates_arriere_doite", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.4627F, -0.0209F, 3.1534F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r24 = pates_arriere_doite.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.0119F, 1.0723F, 0.5F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}