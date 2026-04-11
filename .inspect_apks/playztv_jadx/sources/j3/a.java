package j3;

import com.bumptech.glide.d;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.l0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bumptech.glide.c {
    public static final Pattern f = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharsetDecoder f6760d = StandardCharsets.UTF_8.newDecoder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharsetDecoder f6761e = StandardCharsets.ISO_8859_1.newDecoder();

    @Override // com.bumptech.glide.c
    public final l0 i(f3.a aVar, ByteBuffer byteBuffer) {
        String string;
        CharsetDecoder charsetDecoder = this.f6761e;
        CharsetDecoder charsetDecoder2 = this.f6760d;
        String str = null;
        try {
            string = charsetDecoder2.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string2 = charsetDecoder.decode(byteBuffer).toString();
                charsetDecoder.reset();
                byteBuffer.rewind();
                string = string2;
            } catch (CharacterCodingException unused2) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                string = null;
            } catch (Throwable th) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            charsetDecoder2.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (string == null) {
            return new l0(new c(null, null, bArr));
        }
        Matcher matcher = f.matcher(string);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strX = d.X(strGroup);
                strX.getClass();
                if (strX.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strX.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new l0(new c(str, str2, bArr));
    }
}
