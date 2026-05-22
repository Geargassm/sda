// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class biter_nest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "biter_nest"), "main");
	private final ModelPart base;
	private final ModelPart base2;
	private final ModelPart base3;
	private final ModelPart base4;
	private final ModelPart base5;
	private final ModelPart base6;
	private final ModelPart button;

	public biter_nest(ModelPart root) {
		this.base = root.getChild("base");
		this.base2 = root.getChild("base2");
		this.base3 = root.getChild("base3");
		this.base4 = root.getChild("base4");
		this.base5 = root.getChild("base5");
		this.base6 = root.getChild("base6");
		this.button = root.getChild("button");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -5.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-6.0F, -1.0F, -5.0F, 7.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(14, 50).addBox(-4.0F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 48).addBox(5.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 48).addBox(-1.0F, -1.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 50).addBox(-7.0F, -1.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base2 = partdefinition.addOrReplaceChild("base2", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -2.0F, -5.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(30, 23).addBox(-5.0F, -2.0F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(10, 52).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 52).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(4.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 8).addBox(-1.0F, -2.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base3 = partdefinition.addOrReplaceChild("base3", CubeListBuilder.create().texOffs(30, 32).addBox(0.0F, -1.0F, -4.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(-5.0F, -1.0F, -3.0F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(36, 53).addBox(4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition base4 = partdefinition.addOrReplaceChild("base4", CubeListBuilder.create().texOffs(0, 34).addBox(0.0F, -1.0F, -4.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(34, 16).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 49).addBox(4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition base5 = partdefinition.addOrReplaceChild("base5", CubeListBuilder.create().texOffs(34, 8).addBox(0.0F, -1.0F, -3.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(42, 42).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(26, 49).addBox(3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition base6 = partdefinition.addOrReplaceChild("base6", CubeListBuilder.create().texOffs(26, 42).addBox(0.0F, -1.0F, -2.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 51).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 53).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 44).addBox(2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition button = partdefinition.addOrReplaceChild("button", CubeListBuilder.create().texOffs(54, 10).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 10).addBox(0.0F, -2.4F, -1.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 14).addBox(-5.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 18).addBox(-8.0F, -2.0F, -6.2F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 54).addBox(-7.0F, -2.3F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 54).addBox(-8.0F, -2.0F, -12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 54).addBox(-3.0F, -2.4F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 54).addBox(-3.0F, -2.0F, -15.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(4.0F, -2.5F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(5.0F, -2.2F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(5.0F, -2.0F, -12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 56).addBox(5.0F, -2.4F, -4.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 56).addBox(6.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 56).addBox(3.2F, -4.3F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 32).addBox(-1.0F, -4.2F, -3.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 36).addBox(-5.1F, -4.3F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 57).addBox(-2.0F, -3.3F, -11.1F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 57).addBox(-3.1F, -6.2F, -8.2F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 0).addBox(1.1F, -6.3F, -10.1F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 4).addBox(2.1F, -6.1F, -6.9F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 4).addBox(-0.6F, -5.3F, -5.1F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		button.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}