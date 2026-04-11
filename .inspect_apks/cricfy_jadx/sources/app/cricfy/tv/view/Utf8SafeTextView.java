package app.cricfy.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.regex.Pattern;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class Utf8SafeTextView extends a1 {
    public static final Charset C = StandardCharsets.ISO_8859_1;
    public static final Pattern D = Pattern.compile("\\p{M}+");
    public static final Pattern E = Pattern.compile("[^a-zA-Z0-9\\s:|.-]");
    public static final Pattern F = Pattern.compile("\\s+");

    public Utf8SafeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static boolean g(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 194 || cCharAt == 195 || cCharAt == 197 || cCharAt == 226) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Charset charset = C;
        if (charSequence == null) {
            super.setText((CharSequence) null, bufferType);
            return;
        }
        String string = charSequence.toString();
        if (g(string)) {
            try {
                string = new String(string.getBytes(charset), StandardCharsets.UTF_8);
            } catch (Exception unused) {
            }
            if (g(string)) {
                try {
                    string = new String(string.getBytes(charset), StandardCharsets.UTF_8);
                } catch (Exception unused2) {
                }
            }
        }
        super.setText(F.matcher(E.matcher(D.matcher(Normalizer.normalize(string, Normalizer.Form.NFD)).replaceAll("")).replaceAll("")).replaceAll(" ").trim(), bufferType);
    }
}
