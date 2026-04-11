package n7;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8825c;

    public /* synthetic */ a(String str, boolean z2, int i) {
        this.f8823a = i;
        this.f8825c = str;
        this.f8824b = z2;
    }

    public String toString() {
        switch (this.f8823a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = this.f8825c;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
                sb2.append("{");
                sb2.append(str);
                sb2.append("}");
                sb2.append(this.f8824b);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(boolean z2, String str, int i) {
        this.f8823a = i;
        this.f8824b = z2;
        this.f8825c = str;
    }
}
