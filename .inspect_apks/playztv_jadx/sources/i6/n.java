package i6;

import android.content.Context;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6417b;

    public n(Context context, int i) {
        this.f6416a = i;
        switch (i) {
            case 1:
                this.f6417b = context.getApplicationContext();
                break;
            case 2:
                this.f6417b = context.getApplicationContext();
                break;
            default:
                this.f6417b = context;
                break;
        }
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        Long l10;
        switch (this.f6416a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri = (Uri) obj;
                return new q(new w6.d(uri), new m(this.f6417b, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i > 512 || i10 > 384) {
                    return null;
                }
                w6.d dVar = new w6.d(uri2);
                Context context = this.f6417b;
                return new q(dVar, d6.b.d(context, uri2, new d6.a(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i > 512 || i10 > 384 || (l10 = (Long) iVar.c(l6.d0.f7966d)) == null || l10.longValue() != -1) {
                    return null;
                }
                w6.d dVar2 = new w6.d(uri3);
                Context context2 = this.f6417b;
                return new q(dVar2, d6.b.d(context2, uri3, new d6.a(context2.getContentResolver(), 1)));
        }
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        switch (this.f6416a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return i5.a.C((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return i5.a.C(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return i5.a.C(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
