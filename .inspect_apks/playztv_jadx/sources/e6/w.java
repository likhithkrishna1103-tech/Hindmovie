package e6;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Appendable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Appendable f4571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4572v = true;

    public w(Appendable appendable) {
        this.f4571u = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) throws IOException {
        boolean z2 = this.f4572v;
        Appendable appendable = this.f4571u;
        if (z2) {
            this.f4572v = false;
            appendable.append("  ");
        }
        this.f4572v = c9 == '\n';
        appendable.append(c9);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i10) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z2 = this.f4572v;
        Appendable appendable = this.f4571u;
        boolean z10 = false;
        if (z2) {
            this.f4572v = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i10 - 1) == '\n') {
            z10 = true;
        }
        this.f4572v = z10;
        appendable.append(charSequence, i, i10);
        return this;
    }
}
