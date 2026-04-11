package ad;

import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f794c;

    public a(int i, int i10, int i11) {
        this.f794c = i11;
        this.f792a = i;
        this.f793b = i10;
    }

    public final void a(z4.a aVar) {
        switch (this.f794c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_extras' TEXT NOT NULL DEFAULT '{}'");
                break;
            case 1:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_download_on_enqueue' INTEGER NOT NULL DEFAULT 1");
                break;
            case 2:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_tag' TEXT NULL DEFAULT NULL");
                break;
            case 3:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_max_attempts' INTEGER NOT NULL DEFAULT '0'");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_attempts' INTEGER NOT NULL DEFAULT '0'");
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_identifier' INTEGER NOT NULL DEFAULT 0");
                break;
            default:
                h.e(aVar, "db");
                aVar.n("ALTER TABLE 'requests' ADD COLUMN '_enqueue_action' INTEGER NOT NULL DEFAULT 0");
                break;
        }
    }
}
