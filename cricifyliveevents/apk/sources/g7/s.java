package g7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements x6.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x6.l f5215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5216c;

    public s(x6.l lVar, boolean z10) {
        this.f5215b = lVar;
        this.f5216c = z10;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        this.f5215b.a(messageDigest);
    }

    @Override // x6.l
    public final z6.b0 b(Context context, z6.b0 b0Var, int i, int i10) {
        a7.b bVar = com.bumptech.glide.b.a(context).f2193v;
        Drawable drawable = (Drawable) b0Var.get();
        d dVarB = r.b(bVar, drawable, i, i10);
        if (dVarB != null) {
            z6.b0 b0VarB = this.f5215b.b(context, dVarB, i, i10);
            if (!b0VarB.equals(dVarB)) {
                return new d(context.getResources(), b0VarB);
            }
            b0VarB.e();
            return b0Var;
        }
        if (!this.f5216c) {
            return b0Var;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f5215b.equals(((s) obj).f5215b);
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        return this.f5215b.hashCode();
    }
}
