package i2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f5988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f5989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5990c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.f5990c = fVar;
        this.f5988a = contentResolver;
        this.f5989b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        f fVar = this.f5990c;
        fVar.d(c.c((Context) fVar.f5993b, (v1.c) fVar.f5999j, (p6.d) fVar.i));
    }
}
