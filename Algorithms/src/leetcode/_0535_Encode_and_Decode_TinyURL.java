/**
 *  @author  Yunxiang He
 *  @date    Jan 7, 2018 4:24:36 PM
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

Note: This is a companion problem to the System Design problem: Design TinyURL.

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

 */

public class _0535_Encode_and_Decode_TinyURL {
    private Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://host.com/" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl.replace("http://host.com/", "")));
    }

    public static void main(String[] args) {
        _0535_Encode_and_Decode_TinyURL test = new _0535_Encode_and_Decode_TinyURL();
        System.out.println(test.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(test.decode("http://host.com/-1163677885"));
    }
}