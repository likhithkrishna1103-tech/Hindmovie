package ed;

import androidx.media3.decoder.DecoderInputBuffer;
import d5.b;
import g1.h;
import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3889c;

    public a(int i, int i10, int i11) {
        this.f3889c = i11;
        this.f3887a = i;
        this.f3888b = i10;
    }

    public final void a(b bVar) {
        switch (this.f3889c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_extras' TEXT NOT NULL DEFAULT '{}'");
                break;
            case 1:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_download_on_enqueue' INTEGER NOT NULL DEFAULT 1");
                break;
            case 2:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_tag' TEXT NULL DEFAULT NULL");
                break;
            case 3:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_max_attempts' INTEGER NOT NULL DEFAULT '0'");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_attempts' INTEGER NOT NULL DEFAULT '0'");
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_identifier' INTEGER NOT NULL DEFAULT 0");
                break;
            default:
                i.e(bVar, "db");
                bVar.m("ALTER TABLE 'requests' ADD COLUMN '_enqueue_action' INTEGER NOT NULL DEFAULT 0");
                break;
        }
    }
}
