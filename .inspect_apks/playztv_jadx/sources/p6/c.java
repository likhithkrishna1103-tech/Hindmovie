package p6;

import android.content.Context;
import android.graphics.Bitmap;
import c6.m;
import e6.b0;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f10219b;

    public c(m mVar) {
        x6.f.c(mVar, "Argument must not be null");
        this.f10219b = mVar;
    }

    @Override // c6.m
    public final b0 a(Context context, b0 b0Var, int i, int i10) {
        b bVar = (b) b0Var.get();
        b0 dVar = new l6.d(((g) bVar.f10213u.f5886b).f10237l, com.bumptech.glide.b.a(context).f2760u);
        m mVar = this.f10219b;
        b0 b0VarA = mVar.a(context, dVar, i, i10);
        if (!dVar.equals(b0VarA)) {
            dVar.d();
        }
        ((g) bVar.f10213u.f5886b).c(mVar, (Bitmap) b0VarA.get());
        return b0Var;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        this.f10219b.b(messageDigest);
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f10219b.equals(((c) obj).f10219b);
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return this.f10219b.hashCode();
    }
}
