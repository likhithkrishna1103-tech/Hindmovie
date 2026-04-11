package d7;

import android.content.Context;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3504b;

    public p(Context context, int i) {
        this.f3503a = i;
        switch (i) {
            case 1:
                this.f3504b = context.getApplicationContext();
                break;
            case 2:
                this.f3504b = context.getApplicationContext();
                break;
            default:
                this.f3504b = context;
                break;
        }
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        Long l10;
        switch (this.f3503a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri uri = (Uri) obj;
                return new s(new r7.b(uri), new o(0, this.f3504b, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i > 512 || i10 > 384) {
                    return null;
                }
                r7.b bVar = new r7.b(uri2);
                Context context = this.f3504b;
                return new s(bVar, f.c(context, uri2, new y6.a(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i > 512 || i10 > 384 || (l10 = (Long) hVar.c(g7.g0.f5184d)) == null || l10.longValue() != -1) {
                    return null;
                }
                r7.b bVar2 = new r7.b(uri3);
                Context context2 = this.f3504b;
                return new s(bVar2, f.c(context2, uri3, new y6.a(context2.getContentResolver(), 1)));
        }
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        switch (this.f3503a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return t1.j((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return t1.j(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return t1.j(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
