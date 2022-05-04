package com.example.myblog.controller.api;


import com.example.myblog.config.auth.PrincipalDetail;
import com.example.myblog.domain.user.User;
import com.example.myblog.domain.user.UserSaveRequestDto;
import com.example.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto.toEntity());
    }

    @PutMapping("/api/v1/user")
    public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        userService.update(user, principalDetail);
        return user.getId();
    }
}
