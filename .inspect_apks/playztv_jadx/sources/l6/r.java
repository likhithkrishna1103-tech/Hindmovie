package l6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements c6.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c6.m f7998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7999c;

    public r(c6.m mVar, boolean z2) {
        this.f7998b = mVar;
        this.f7999c = z2;
    }

    @Override // c6.m
    public final e6.b0 a(Context context, e6.b0 b0Var, int i, int i10) {
        f6.a aVar = com.bumptech.glide.b.a(context).f2760u;
        Drawable drawable = (Drawable) b0Var.get();
        d dVarA = q.a(aVar, drawable, i, i10);
        if (dVarA != null) {
            e6.b0 b0VarA = this.f7998b.a(context, dVarA, i, i10);
            if (!b0VarA.equals(dVarA)) {
                return new d(context.getResources(), b0VarA);
            }
            b0VarA.d();
            return b0Var;
        }
        if (!this.f7999c) {
            return b0Var;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        this.f7998b.b(messageDigest);
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f7998b.equals(((r) obj).f7998b);
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return this.f7998b.hashCode();
    }
}
