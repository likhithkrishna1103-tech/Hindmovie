package z6;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Appendable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Appendable f15322v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f15323w = true;

    public w(Appendable appendable) {
        this.f15322v = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) throws IOException {
        boolean z10 = this.f15323w;
        Appendable appendable = this.f15322v;
        if (z10) {
            this.f15323w = false;
            appendable.append("  ");
        }
        this.f15323w = c9 == '\n';
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
        boolean z10 = this.f15323w;
        Appendable appendable = this.f15322v;
        boolean z11 = false;
        if (z10) {
            this.f15323w = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i10 - 1) == '\n') {
            z11 = true;
        }
        this.f15323w = z11;
        appendable.append(charSequence, i, i10);
        return this;
    }
}
