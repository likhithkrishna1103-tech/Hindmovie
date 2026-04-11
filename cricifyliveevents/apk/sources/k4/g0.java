package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements k0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7004v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l0 f7005w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f7006x;

    public /* synthetic */ g0(l0 l0Var, int i, int i10) {
        this.f7004v = i10;
        this.f7005w = l0Var;
        this.f7006x = i;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // k4.k0
    public final void d(s sVar) {
        int i = this.f7004v;
        int i10 = 0;
        z = false;
        boolean z10 = false;
        i10 = 0;
        i10 = 0;
        int i11 = this.f7006x;
        l0 l0Var = this.f7005w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h1 h1Var = l0Var.f7060g.f6924t;
                int i12 = l.f7058a;
                if (i11 != -1 && i11 != 0) {
                    if (i11 == 1) {
                        i10 = 1;
                    } else if (i11 == 2 || i11 == 3) {
                        i10 = 2;
                    } else {
                        y1.b.p("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + i11 + " was converted to `Player.REPEAT_MODE_OFF`");
                    }
                }
                h1Var.g0(i10);
                return;
            default:
                h1 h1Var2 = l0Var.f7060g.f6924t;
                int i13 = l.f7058a;
                if (i11 != -1 && i11 != 0) {
                    if (i11 != 1 && i11 != 2) {
                        throw new IllegalArgumentException(l0.e.g(i11, "Unrecognized ShuffleMode: "));
                    }
                    z10 = true;
                }
                h1Var2.A(z10);
                return;
        }
    }
}
