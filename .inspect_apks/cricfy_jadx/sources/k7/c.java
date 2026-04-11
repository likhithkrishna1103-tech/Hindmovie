package k7;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import x6.l;
import z6.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f7217b;

    public c(l lVar) {
        s7.f.c(lVar, "Argument must not be null");
        this.f7217b = lVar;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        this.f7217b.a(messageDigest);
    }

    @Override // x6.l
    public final b0 b(Context context, b0 b0Var, int i, int i10) {
        b bVar = (b) b0Var.get();
        b0 dVar = new g7.d(com.bumptech.glide.b.a(context).f2193v, ((g) bVar.f7212v.f1841b).f7234l);
        l lVar = this.f7217b;
        b0 b0VarB = lVar.b(context, dVar, i, i10);
        if (!dVar.equals(b0VarB)) {
            dVar.e();
        }
        ((g) bVar.f7212v.f1841b).c(lVar, (Bitmap) b0VarB.get());
        return b0Var;
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f7217b.equals(((c) obj).f7217b);
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        return this.f7217b.hashCode();
    }
}
