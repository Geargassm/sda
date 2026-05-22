// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class SmallBiter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "smallbiter"), "main");
	private final ModelPart biter;
	private final ModelPart carapace;
	private final ModelPart tete;
	private final ModelPart 1;
	private final ModelPart 2;
	private final ModelPart 3;
	private final ModelPart 4;
	private final ModelPart 5;
	private final ModelPart 6;
	private final ModelPart pates_avant_gauche;
	private final ModelPart pates_avant_doite;
	private final ModelPart pates_milieu_droit;
	private final ModelPart pates_millieu_gauche;
	private final ModelPart pates_arriere_gauche;
	private final ModelPart pates_arriere_doite;

	public SmallBiter(ModelPart root) {
		this.biter = root.getChild("biter");
		this.carapace = this.biter.getChild("carapace");
		this.tete = this.carapace.getChild("tete");
		this.1 = this.carapace.getChild("1");
		this.2 = this.carapace.getChild("2");
		this.3 = this.carapace.getChild("3");
		this.4 = this.carapace.getChild("4");
		this.5 = this.carapace.getChild("5");
		this.6 = this.carapace.getChild("6");
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

		PartDefinition biter = partdefinition.addOrReplaceChild("biter", CubeListBuilder.create(), PartPose.offset(0.0F, 27.0F, 0.0F));

		PartDefinition carapace = biter.addOrReplaceChild("carapace", CubeListBuilder.create(), PartPose.offset(-1.0F, -4.8F, -3.4F));

		PartDefinition tete = carapace.addOrReplaceChild("tete", CubeListBuilder.create(), PartPose.offset(2.0F, 0.5F, -1.0F));

		PartDefinition carapace_r1 = tete.addOrReplaceChild("carapace_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.9599F, 0.6109F));

		PartDefinition carapace_r2 = tete.addOrReplaceChild("carapace_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.9599F, -0.6109F));

		PartDefinition 1 = carapace.addOrReplaceChild("1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition carapace_r3 = 1.addOrReplaceChild("carapace_r3", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r4 = 1.addOrReplaceChild("carapace_r4", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition 2 = carapace.addOrReplaceChild("2", CubeListBuilder.create(), PartPose.offset(2.0F, -0.5F, 2.6F));

		PartDefinition carapace_r5 = 2.addOrReplaceChild("carapace_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r6 = 2.addOrReplaceChild("carapace_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition 3 = carapace.addOrReplaceChild("3", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, 4.2F));

		PartDefinition carapace_r7 = 3.addOrReplaceChild("carapace_r7", CubeListBuilder.create().texOffs(10, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition carapace_r8 = 3.addOrReplaceChild("carapace_r8", CubeListBuilder.create().texOffs(10, 9).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition 4 = carapace.addOrReplaceChild("4", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 5.9F));

		PartDefinition carapace_r9 = 4.addOrReplaceChild("carapace_r9", CubeListBuilder.create().texOffs(10, 5).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r10 = 4.addOrReplaceChild("carapace_r10", CubeListBuilder.create().texOffs(10, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition 5 = carapace.addOrReplaceChild("5", CubeListBuilder.create(), PartPose.offset(2.0F, 0.3F, 7.4F));

		PartDefinition carapace_r11 = 5.addOrReplaceChild("carapace_r11", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r12 = 5.addOrReplaceChild("carapace_r12", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition 6 = carapace.addOrReplaceChild("6", CubeListBuilder.create(), PartPose.offset(2.0F, 0.6F, 8.5F));

		PartDefinition carapace_r13 = 6.addOrReplaceChild("carapace_r13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition carapace_r14 = 6.addOrReplaceChild("carapace_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition pates_avant_gauche = biter.addOrReplaceChild("pates_avant_gauche", CubeListBuilder.create(), PartPose.offsetAndRotation(2.1836F, -2.7136F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r1 = pates_avant_gauche.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_avant_doite = biter.addOrReplaceChild("pates_avant_doite", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1836F, -2.7136F, -3.0585F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = pates_avant_doite.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.9336F, 1.6401F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_milieu_droit = biter.addOrReplaceChild("pates_milieu_droit", CubeListBuilder.create(), PartPose.offset(-1.8348F, -2.0724F, -0.9654F));

		PartDefinition cube_r3 = pates_milieu_droit.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 17).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition pates_millieu_gauche = biter.addOrReplaceChild("pates_millieu_gauche", CubeListBuilder.create(), PartPose.offset(2.2619F, -2.0724F, -0.5F));

		PartDefinition cube_r4 = pates_millieu_gauche.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 17).mirror().addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_gauche = biter.addOrReplaceChild("pates_arriere_gauche", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5076F, -2.9541F, 2.9857F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r5 = pates_arriere_gauche.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 13).mirror().addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition pates_arriere_doite = biter.addOrReplaceChild("pates_arriere_doite", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4627F, -3.0209F, 3.1534F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r6 = pates_arriere_doite.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0119F, 1.0724F, 0.5F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		biter.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}