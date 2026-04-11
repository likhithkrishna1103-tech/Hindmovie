package j2;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v1.n0;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f6538v = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

    @Override // w2.q
    public final Object g(Uri uri, b2.m mVar) throws IOException {
        String line = new BufferedReader(new InputStreamReader(mVar, StandardCharsets.UTF_8)).readLine();
        try {
            Matcher matcher = f6538v.matcher(line);
            if (!matcher.matches()) {
                throw n0.b("Couldn't parse timestamp: " + line, null);
            }
            String strGroup = matcher.group(1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            long time = simpleDateFormat.parse(strGroup).getTime();
            if (!"Z".equals(matcher.group(2))) {
                long j4 = "+".equals(matcher.group(4)) ? 1L : -1L;
                long j7 = Long.parseLong(matcher.group(5));
                String strGroup2 = matcher.group(7);
                time -= (((j7 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60000) * j4;
            }
            return Long.valueOf(time);
        } catch (ParseException e9) {
            throw n0.b(null, e9);
        }
    }
}
