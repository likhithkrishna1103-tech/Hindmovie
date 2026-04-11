package c2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f2254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f2255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2256c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.f2256c = fVar;
        this.f2254a = contentResolver;
        this.f2255b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        f fVar = this.f2256c;
        fVar.a(b.c((Context) fVar.f2300b, (p1.d) fVar.f2306j, (wb.c) fVar.i));
    }
}
